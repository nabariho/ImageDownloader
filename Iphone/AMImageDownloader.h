/********* AMImageDownloader Cordova Plugin Header *******/

#import <Cordova/CDVPlugin.h>

@interface AMImageDownloader : CDVPlugin
    - (void)downloadAndSaveImage:(CDVInvokedUrlCommand*)command;
@end
