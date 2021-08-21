<template>
  <div id="app">
    <Title />
    <PlanetChart />
    <Support />
  </div>
</template>

<script>
import Title from "./components/Title.vue";
import PlanetChart from "./components/PlanetChart.vue";
import Support from "./components/Support.vue";
import { provide } from "@vue/runtime-core";

export default {
  name: "App",
  setup() {
    provide("backendApiUrl", "http://localhost:8080");
    provide("apiCurrencyQueryAll", "/currency/query/all");
  },
  components: {
    Title,
    PlanetChart,
    Support,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
