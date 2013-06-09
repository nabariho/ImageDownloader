AMImageDownloader Plugin
============

This plugin allows you to download images from URL and save them to the photo gallery of IOS or Android

Installation
------------

IOS
------------

1.  Add the AMImageDownloader.h and  AMImageDownloader.m classes to your Plugins folder in Xcode
2.  Add the AMImageDownloader.js file to your www folder
3.  Add the AMImageDownloader.js to your html file. eg: `<script type="text/javascript" charset="utf-8" src="AMImageDownloader.js"></script>`
4.  Add the plugin to your config.xml  `<plugin name="AMImageDownloader" value="AMImageDownloader" />`

Android
------------
1. add the plugin to your config.xml `<plugin name="AMImageDownloader" value="org.apache.cordova.plugin.AMImageDownloader" />`
2. Add the  AMImageDownloader.java class to your  project. You must be sure that the package is org.apache.cordova.plugin
3. Add the AMImageDownloader.js file to your www folder
4.  Add the AMImageDownloader.js to your html file. eg: `<script type="text/javascript" charset="utf-8" `src="AMImageDownloader.js"></script>


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


## License

The MIT License (MIT)

The MIT License (MIT)

Copyright (c) 2013 Rubén Domínguez  (https://github.com/nabariho, ruben@theagilemonkeys.com)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
