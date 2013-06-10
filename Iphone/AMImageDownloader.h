//
//  AMImageDownloader Cordova Plugin Header
//
//
//  Created by Ruben on 08/06/13.
//  Copyright (c) 2013 Ruben Domínguez. All rights reserved.
//  MIT Licensed
//

#import <Cordova/CDVPlugin.h>

@interface AMImageDownloader : CDVPlugin
    - (void)downloadAndSaveImage:(CDVInvokedUrlCommand*)command;
@end
