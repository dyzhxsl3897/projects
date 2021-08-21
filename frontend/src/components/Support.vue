<template>
  <div class="intro">
    <div>
      <h4>This project is built on</h4>
      <ul>
        <li v-for="support in supports" :key="support.name">
          <a :href="`${support.url}`">{{ support.name }}</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "Support",
  data() {
    return {
      supports: [
        { name: "Vue@3.1.5", url: "https://vuejs.org/" },
        { name: "Chart.js@2.9.3", url: "https://www.chartjs.org/" },
        { name: "axios", url: "https://axios-http.com/" },
      ],
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
div.intro {
  position: fixed;
  bottom: 0px;
  left: 0px;
  right: 0px;
  margin: auto;
}
h4 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline;
  padding: 10px;
}
a {
  color: #42b983;
}
</style>
