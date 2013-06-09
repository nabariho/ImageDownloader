//
//  AMImageDownloader.js
//  AMImageDownloader PhoneGap/Cordova plugin
//
//  Created by Ruben on 08/06/13.
¡//  Copyright (c) 2013 Ruben Domínguez. All rights reserved.
//  MIT Licensed
//


var DownloadImagePlugin = {
  callDownloadAndSaveImage: function(successCallback, failureCallback,url) {
        return cordova.exec(
                successCallback,
                failureCallback,
                'AMImageDownloader',      // Nombre con el que está registrado el plugin Java
                'downloadAndSaveImage',  // Acción invocada
                [url]);
    }
};
