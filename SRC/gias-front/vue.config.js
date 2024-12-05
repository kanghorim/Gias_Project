const { defineConfig } = require('@vue/cli-service')
const path = require("path")
module.exports = defineConfig({
  devServer: {
    proxy : process.env.VUE_APP_API_URL
  },
  transpileDependencies: true,
  lintOnSave:false,
  //outputDir: path.resolve(__dirname, "./dist"),
  publicPath: process.env.NODE_ENV === 'production' ? './' : '/',
  chainWebpack: config => {
    config.resolve.alias
      .set('@', path.resolve(__dirname, 'src/'))
  }
})
