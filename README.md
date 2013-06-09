AMImageDownloader Plugin
============

This plugin allows you to download images from URL and save them to the photo gallery of IOS or Android

Installation
------------

IOS
------------

1.  Add the AMImageDownloader.h and  AMImageDownloader.m classes to your Plugins folder in Xcode
2.  Add the AMImageDownloader.js file to your www folder
3.  Add the AMImageDownloader.js to your html file. eg: `<script type="text/javascript" charset="utf-8" src="AMImageDownloader.js"></script>
4.  Add the plugin to your config.xml  <plugin name="AMImageDownloader" value="AMImageDownloader" />

Android
------------
1. add the plugin to your config.xml <plugin name="AMImageDownloader" value="org.apache.cordova.plugin.AMImageDownloader" />
2. Add the  AMImageDownloader.java class to your  project. You must be sure that the package is org.apache.cordova.plugin
3 Add the AMImageDownloader.js file to your www folder
4.  Add the AMImageDownloader.js to your html file. eg: `<script type="text/javascript" charset="utf-8" src="AMImageDownloader.js"></script>


Finally, call the `DownloadAndSaveImage()` method using success and error callbacks and the url of the image

### Example
```html
```

```javascript
function onDeviceReady()
{
  var file = "http://optipng.sourceforge.net/pngtech/img/lena.png";
  DownloadImagePlugin.callDownloadAndSaveImage(
  (function(msg) {
    return alert(msg);
  }),
  (function(err) {
    return alert(err);
  }),
  file);
}
