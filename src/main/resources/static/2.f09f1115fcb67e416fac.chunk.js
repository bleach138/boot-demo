webpackJsonp([2],{1286:function(r,a,n){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var e=n(35),s=n(6),t=n(530),o=(n.n(t),n(521)),l=n(520),i=(n.n(l),n(1300)),c=n(1306);n.d(a,"DashboardModule",(function(){return d}));var d=(function(){function r(){}return r})();d=e.a([n.i(s.NgModule)({imports:[c.a,t.ChartsModule,o.a,l.EchartsNg2Module],declarations:[i.a]})],d)},1300:function(r,a,n){"use strict";var e=n(35),s=n(6);n.d(a,"a",(function(){return t}));var t=(function(){function r(){this.brandPrimary="#20a8d8",this.brandSuccess="#4dbd74",this.brandInfo="#63c2de",this.brandWarning="#f8cb00",this.brandDanger="#f86c6b",this.status={isopen:!1},this.socialChartData1=[{data:[65,59,84,84,51,55,40],label:"Facebook"}],this.socialChartData2=[{data:[1,13,9,17,34,41,38],label:"Twitter"}],this.socialChartData3=[{data:[78,81,80,45,34,12,40],label:"LinkedIn"}],this.socialChartData4=[{data:[35,23,56,22,97,23,64],label:"Google+"}],this.socialChartLabels=["January","February","March","April","May","June","July"],this.socialChartOptions={responsive:!0,maintainAspectRatio:!1,scales:{xAxes:[{display:!1}],yAxes:[{display:!1}]},elements:{line:{borderWidth:2},point:{radius:0,hitRadius:10,hoverRadius:4,hoverBorderWidth:3}},legend:{display:!1}},this.socialChartColours=[{backgroundColor:"rgba(255,255,255,.1)",borderColor:"rgba(255,255,255,.55)",pointHoverBackgroundColor:"#fff"}],this.socialChartLegend=!1,this.socialChartType="line",this.onlineUserOption={title:{text:"在线用户"},tooltip:{},xAxis:{data:["2017-4-10","2017-4-11","2017-4-12","2017-4-13","2017-4-14"],splitLine:{show:!1}},yAxis:{splitLine:{show:!1}},series:[{name:"人数",type:"bar",data:[5,20,36,10,10]}]},this.top5UserOption={title:{text:"前5名用户流量"},tooltip:{trigger:"item",formatter:"{a} <br/>{b} : {c} ({d}%)"},legend:{x:"center",y:"bottom",data:["rose1","rose2","rose3","rose4","rose5","rose6","rose7","rose8"]},calculable:!0,series:[{name:"面积模式",type:"pie",radius:[30,110],roseType:"area",data:[{value:10,name:"rose1"},{value:5,name:"rose2"},{value:15,name:"rose3"},{value:25,name:"rose4"},{value:20,name:"rose5"},{value:35,name:"rose6"},{value:30,name:"rose7"},{value:40,name:"rose8"}]}]},this.top5AddressFlowOption={title:{text:"前5名目标地址流量"},tooltip:{trigger:"item",formatter:"{a} <br/>{b} : {c} ({d}%)"},legend:{x:"center",y:"bottom",data:["rose1","rose2","rose3","rose4","rose5","rose6","rose7","rose8"]},calculable:!0,series:[{name:"面积模式",type:"pie",radius:[30,110],roseType:"area",data:[{value:10,name:"rose1"},{value:5,name:"rose2"},{value:15,name:"rose3"},{value:65,name:"rose4"},{value:20,name:"rose5"},{value:35,name:"rose6"},{value:20,name:"rose7"},{value:40,name:"rose8"}]}]},this.top5AppFlowOption={title:{text:"前5名应用流量"},tooltip:{trigger:"item",formatter:"{a} <br/>{b} : {c} ({d}%)"},legend:{x:"center",y:"bottom",data:["rose1","rose2","rose3","rose4","rose5","rose6","rose7","rose8"]},calculable:!0,series:[{name:"面积模式",type:"pie",radius:[30,110],roseType:"area",data:[{value:10,name:"rose1"},{value:5,name:"rose2"},{value:15,name:"rose3"},{value:35,name:"rose4"},{value:20,name:"rose5"},{value:5,name:"rose6"},{value:30,name:"rose7"},{value:40,name:"rose8"}]}]},this.netStatusOption={title:{text:"网络状态"},tooltip:{trigger:"axis"},legend:{data:["外网上行速率","外网下行速率"]},grid:{left:"3%",right:"4%",bottom:"3%",containLabel:!0},toolbox:{},xAxis:{type:"category",boundaryGap:!1,splitLine:{show:!1},data:["周一","周二","周三","周四","周五","周六","周日"]},yAxis:{type:"value",splitLine:{show:!1}},series:[{name:"外网上行速率",type:"line",stack:"总量",data:[120,132,101,134,90,230,210]},{name:"外网下行速率",type:"line",stack:"总量",data:[220,182,191,234,290,330,310]}]},this.netSpeedOption={title:{text:"网络加速状态"},tooltip:{trigger:"axis"},legend:{data:["外网上行速率","外网下行速率"]},grid:{left:"3%",right:"4%",bottom:"3%",containLabel:!0},toolbox:{},xAxis:{type:"category",boundaryGap:!1,splitLine:{show:!1},data:["周一","周二","周三","周四","周五","周六","周日"]},yAxis:{type:"value",splitLine:{show:!1}},series:[{name:"外网上行速率",type:"line",stack:"总量",data:[120,132,101,134,90,230,210]},{name:"外网下行速率",type:"line",stack:"总量",data:[220,182,191,234,290,330,310]}]}}return r.prototype.toggleDropdown=function(r){r.preventDefault(),r.stopPropagation(),this.status.isopen=!this.status.isopen},r.prototype.ngOnInit=function(){},r})();t=e.a([n.i(s.Component)({template:n(1309)})],t)},1306:function(r,a,n){"use strict";var e=n(35),s=n(6),t=n(88),o=n(1300);n.d(a,"a",(function(){return i}));var l=[{path:"",component:o.a,data:{title:"Dashboard"}}],i=(function(){function r(){}return r})();i=e.a([n.i(s.NgModule)({imports:[t.a.forChild(l)],exports:[t.a]})],i)},1309:function(r,a){r.exports='<div class="animated fadeIn">\r\n  <!--/.card-->\r\n  <div class="row">\r\n    <div class="col-sm-6 col-lg-3">\r\n      <div class="social-box facebook">\r\n        <i class="fa fa-facebook"></i>\r\n        <div class="chart-wrapper">\r\n          <canvas baseChart class="chart"\r\n          [datasets]="socialChartData1"\r\n          [labels]="socialChartLabels"\r\n          [options]="socialChartOptions"\r\n          [colors]="socialChartColours"\r\n          [legend]="socialChartLegend"\r\n          [chartType]="socialChartType"\r\n          (chartHover)="chartHovered($event)"\r\n          (chartClick)="chartClicked($event)"></canvas>\r\n        </div>\r\n        <ul>\r\n          <li>\r\n            <strong>89k</strong>\r\n            <span>wan</span>\r\n          </li>\r\n          <li>\r\n            <strong>459</strong>\r\n            <span>feeds</span>\r\n          </li>\r\n        </ul>\r\n      </div>\r\n      <!--/.social-box-->\r\n    </div><!--/.col-->\r\n    <div class="col-sm-6 col-lg-3">\r\n      <div class="social-box twitter">\r\n        <i class="fa fa-twitter"></i>\r\n        <div class="chart-wrapper">\r\n          <canvas baseChart class="chart"\r\n          [datasets]="socialChartData2"\r\n          [labels]="socialChartLabels"\r\n          [options]="socialChartOptions"\r\n          [colors]="socialChartColours"\r\n          [legend]="socialChartLegend"\r\n          [chartType]="socialChartType"\r\n          (chartHover)="chartHovered($event)"\r\n          (chartClick)="chartClicked($event)"></canvas>\r\n        </div>\r\n        <ul>\r\n          <li>\r\n            <strong>973k</strong>\r\n            <span>followers</span>\r\n          </li>\r\n          <li>\r\n            <strong>1.792</strong>\r\n            <span>tweets</span>\r\n          </li>\r\n        </ul>\r\n      </div>\r\n      <!--/.social-box-->\r\n    </div><!--/.col-->\r\n    <div class="col-sm-6 col-lg-3">\r\n      <div class="social-box linkedin">\r\n        <i class="fa fa-linkedin"></i>\r\n        <div class="chart-wrapper">\r\n          <canvas baseChart class="chart"\r\n          [datasets]="socialChartData3"\r\n          [labels]="socialChartLabels"\r\n          [options]="socialChartOptions"\r\n          [colors]="socialChartColours"\r\n          [legend]="socialChartLegend"\r\n          [chartType]="socialChartType"\r\n          (chartHover)="chartHovered($event)"\r\n          (chartClick)="chartClicked($event)"></canvas>\r\n        </div>\r\n        <ul>\r\n          <li>\r\n            <strong>500+</strong>\r\n            <span>contacts</span>\r\n          </li>\r\n          <li>\r\n            <strong>292</strong>\r\n            <span>feeds</span>\r\n          </li>\r\n        </ul>\r\n      </div>\r\n      <!--/.social-box-->\r\n    </div><!--/.col-->\r\n    <div class="col-sm-6 col-lg-3">\r\n      <div class="social-box google-plus">\r\n        <i class="fa fa-google-plus"></i>\r\n        <div class="chart-wrapper">\r\n          <canvas baseChart class="chart"\r\n          [datasets]="socialChartData4"\r\n          [labels]="socialChartLabels"\r\n          [options]="socialChartOptions"\r\n          [colors]="socialChartColours"\r\n          [legend]="socialChartLegend"\r\n          [chartType]="socialChartType"\r\n          (chartHover)="chartHovered($event)"\r\n          (chartClick)="chartClicked($event)"></canvas>\r\n        </div>\r\n        <ul>\r\n          <li>\r\n            <strong>894</strong>\r\n            <span>followers</span>\r\n          </li>\r\n          <li>\r\n            <strong>92</strong>\r\n            <span>circles</span>\r\n          </li>\r\n        </ul>\r\n      </div>\r\n      <!--/.social-box-->\r\n    </div><!--/.col-->\r\n  </div><!--/.row-->\r\n\r\n  <div class="row">\r\n    <div class="col-lg-5 col-md-6 col-xs-12">\r\n      <div class="card card-inverse text-center">\r\n        <div class="card-block">\r\n          <blockquote class="card-blockquote">\r\n            <echarts-ng2 [option]="onlineUserOption"></echarts-ng2>\r\n          </blockquote>\r\n        </div>\r\n      </div>\r\n    </div>\r\n\r\n    <div class="col-lg-4 col-md-6 col-xs-12">\r\n      <div class="card card-inverse text-center">\r\n        <div class="card-block">\r\n          <blockquote class="card-blockquote">\r\n            <echarts-ng2 [option]="top5UserOption"></echarts-ng2>\r\n          </blockquote>\r\n        </div>\r\n      </div>\r\n    </div>\r\n\r\n    <div class="col-lg-3 col-md-6 col-xs-12">\r\n      <div class="card card-inverse text-center">\r\n        <div class="card-block">\r\n          <blockquote class="card-blockquote">\r\n            111112\r\n          </blockquote>\r\n        </div>\r\n      </div>    \r\n    </div>\r\n  </div>\r\n\r\n  <div class="row">\r\n    <div class="col-lg-5 col-md-6 col-xs-12">\r\n      <div class="card card-inverse text-center">\r\n        <div class="card-block">\r\n          <blockquote class="card-blockquote">\r\n            <echarts-ng2 [option]="top5AddressFlowOption"></echarts-ng2>\r\n          </blockquote>\r\n        </div>\r\n      </div>\r\n    </div>\r\n\r\n    <div class="col-lg-4 col-md-6 col-xs-12">\r\n      <div class="card card-inverse text-center">\r\n        <div class="card-block">\r\n          <blockquote class="card-blockquote">\r\n            <echarts-ng2 [option]="top5AppFlowOption"></echarts-ng2>\r\n          </blockquote>\r\n        </div>\r\n      </div>\r\n    </div>\r\n\r\n    <div class="col-lg-3 col-md-6 col-xs-12">\r\n      <div class="card card-inverse text-center">\r\n        <div class="card-block">\r\n          <blockquote class="card-blockquote">\r\n            应用\r\n\r\n \r\n            网盘地址:\r\n\r\n            wwwin.fnic.cn\r\n\r\n            网盘容量\r\n\r\n            100G\r\n          </blockquote>\r\n        </div>\r\n      </div>    \r\n    </div>\r\n  </div>\r\n\r\n  <div class="row">\r\n    <div class="col-md-9">\r\n      <div class="card card-inverse text-center">\r\n        <div class="card-block">\r\n          <blockquote class="card-blockquote">\r\n            <echarts-ng2 [option]="netStatusOption"></echarts-ng2>\r\n          </blockquote>\r\n        </div>\r\n      </div>\r\n    </div>\r\n\r\n    <div class="col-lg-3 col-md-6 col-xs-12">\r\n      <div class="card card-inverse text-center">\r\n        <div class="card-block">\r\n          <blockquote class="card-blockquote">\r\n            应用\r\n          </blockquote>\r\n        </div>\r\n      </div>    \r\n    </div>\r\n  </div>\r\n\r\n  <div class="row">\r\n    <div class="col-md-9">\r\n      <div class="card card-inverse text-center">\r\n        <div class="card-block">\r\n          <blockquote class="card-blockquote">\r\n            <echarts-ng2 [option]="netStatusOption"></echarts-ng2>\r\n          </blockquote>\r\n        </div>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n'}});