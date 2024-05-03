<template>
  <v-app>
    <v-navigation-drawer permanent expand-on-hover rail v-model="drawer" app>
      <v-list>
        <v-list-item
          prepend-avatar="@/assets/IWMT_logo.png"
          class="square-avatar"
          title="Image Warehouse"
          subtitle="Management System"
        ></v-list-item>
      </v-list>

      <v-divider></v-divider>

      <v-list density="compact" nav>
        <v-list-item
          prepend-icon="mdi-folder"
          title="test1"
          value="myfiles"
        ></v-list-item>
        <v-list-item
          prepend-icon="mdi-account-multiple"
          title="test2"
          value="shared"
        ></v-list-item>
        <v-list-item
          prepend-icon="mdi-star"
          title="test3"
          value="starred"
        ></v-list-item>
      </v-list>
    </v-navigation-drawer>


    <v-app-bar app>
      <v-toolbar-title>IWMT（dev）</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <v-container>
        <h1>图像检索</h1>
        <v-text-field
          v-model="filename"
          label="输入完整jb号"
          outlined
        ></v-text-field>
        <v-btn color="primary" @click="fetchImage">搜索</v-btn>
        <!-- Image display area -->
        <v-img :src="imageUrl" height="300" contain v-if="imageUrl"></v-img>
        <div v-if="!imageUrl">无图像</div>
      </v-container>
    </v-main>
    <AppFooter />
  </v-app>
</template>
<style>
.square-avatar .v-avatar {
  border-radius: 0; /* Override the default to make it square */
}
</style>
<script>
import axios from 'axios';
import AppFooter from "@/components/AppFooter.vue";

export default {
  name: 'App',
  components: {AppFooter},
  data() {
    return {
      drawer: null, // 设置为 null 以便于使用 vuetify 的响应式规则
      filename: '', // The filename entered by the user
      imageUrl: '', // The URL of the image to display
    };
  },
  methods: {
    fetchImage() {
      // Construct the URL for the GET request
      const url = `http://192.168.3.28:8080/api/images/${encodeURIComponent(this.filename)}`;

      // Perform the GET request
      axios.get(url, { responseType: 'blob' }) // Indicate that the response should be treated as a Blob
        .then(response => {
          // Create a local URL to the image blob
          this.imageUrl = URL.createObjectURL(response.data);
        })
        .catch(error => {
          console.error('Error fetching image:', error);
          this.imageUrl = ''; // Reset the imageUrl if there's an error
        });
    },
  }
}
</script>
