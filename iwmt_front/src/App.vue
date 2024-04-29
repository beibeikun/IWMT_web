<template>
  <div id="app">
    <h1>{{ message }}</h1>
    <button @click="fetchMessage">Fetch Message</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'App',
  data() {
    return {
      message: 'Click the button to load message from Spring Boot!'
    };
  },
  methods: {
    fetchMessage() {
      axios.get('http://localhost:8080/api/hello')
          .then(response => {
            this.message = response.data.message;
          })
          .catch(error => {
            console.error('There was an error!', error);
          });
    }
  }
}
</script>

<style>
#app {
  text-align: center;
  margin-top: 50px;
}
</style>
