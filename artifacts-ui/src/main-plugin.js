import Vue from 'vue'
import router from "./router-plugin";
import ArtifactsSimpleTable from "../src/components/simple-table.vue";
import ArtifactsAttrInput from "../src/components/attr-input.vue";
import locale from "view-design/dist/locale/en-US";
import "./locale/i18n";
import zh_CN from "./locale/i18n/zh-CN.json";
import en_US from "./locale/i18n/en-US.json";

window.component("ArtifactsSimpleTable", ArtifactsSimpleTable);
window.component("ArtifactsAttrInput", ArtifactsAttrInput);

Vue.config.productionTip = false

Vue.use(ViewUI, {
  transfer: true,
  size: "default",
  locale
});

window.locale("zh-CN", zh_CN);
window.locale("en_US", en_US);

window.addRoutes && window.addRoutes(router, "plugin-name");
