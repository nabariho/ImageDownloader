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
