//
//  AMImageDownloader.m
//
//
//  Created by Ruben on 08/06/13.
//  Copyright (c) 2013 Ruben Domínguez. All rights reserved.
//  MIT Licensed
//

#import "AMImageDownloader.h"

@implementation AMImageDownloader
-(void)downloadAndSaveImage:(CDVInvokedUrlCommand*)command{

    CDVPluginResult* pluginResult = nil;
    NSString* urlString = [command.arguments objectAtIndex:0];

    if (urlString != nil && [urlString length] > 0) {
        NSURL *url = [NSURL URLWithString:urlString];
        UIImage *image = [UIImage imageWithData: [NSData dataWithContentsOfURL:url]];
        UIImageWriteToSavedPhotosAlbum(image, nil, nil, nil);
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    }
    else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}
@end
