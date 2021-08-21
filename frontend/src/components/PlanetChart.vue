<template>
  <div class="planet-chart">
    <p>{{ currencyHistoryApiData }}</p>
    <p>{{ currencyHistoryChartData }}</p>
    <canvas id="planet-chart"></canvas>
    <canvas id="currency-historical-chart"></canvas>
  </div>
</template>

<script>
import axios from "axios";
import Chart from "chart.js";
import planetChartData from "../data/planet-data.js";

export default {
  name: "PlanetChart",
  inject: ["backendApiUrl", "apiCurrencyQueryAll"],
  data() {
    return {
      planetChartData: planetChartData,
      currencyHistoryApiData: null,
      currencyHistoryChartData: null,
    };
  },
  mounted() {
    this.getCurrencyHistory();
    const ctx = document.getElementById("planet-chart");
    new Chart(ctx, this.planetChartData);
  },
  methods: {
    getCurrencyHistory() {
      axios
        .get(`${this.backendApiUrl}${this.apiCurrencyQueryAll}`)
        .then((response) => (this.currencyHistoryApiData = response))
        .catch((error) => console.log(error));
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
div.planet-chart {
  margin: 0 auto;
  position: relative;
  width: 40vw;
  height: 40vh;
}
</style>
