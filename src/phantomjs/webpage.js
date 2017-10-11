system = require('system');
address = system.args[1];//获得命令行第二个参数 接下来会用到  
time = system.args[2];//获得命令行第三个参数 接下来会用到  
if(address == null){
	address = 'http://www.baidu.com';
}
if (time == null) {
	time = "error";
};
console.log("time:"+time);
//创建一个webpage对象
var page = require('webpage').create();
console.log("address: "+address);
//窗口大小
page.viewportSize = { width: 1024, height: 800 }
//截取从(0, 0)为起点的1024 * 800大小的图像
//page.clipRect = { top: 0, left: 0, width: 2560, height: 1600 };
//开启Javascript，允许图片载入，并将userAgent改为"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.31 (KHTML, like Gecko) PhantomJS/19.0"：
page.settings = { javascriptEnabled: true, loadImages: true, userAgent: 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.31 (KHTML, like Gecko) PhantomJS/19.0'};
// 打开页面
page.open(address, function(status) {
  // 输出状态
  console.log("status: " + status);
  if(status === "success") {
    // 如果状态为success，将整个page保存为hfly.jpg（也可以是png，pdf, gif）
    page.render(time+'.jpg');
  }
  phantom.exit();
});