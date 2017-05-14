import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';

/**
 * 1. main.ts 为项目的入口文件。
 * 2. 使用 Angular 自带的 platformBrowserDynamic 编译启动 AppModule，从而启动应用。
 */
platformBrowserDynamic().bootstrapModule(AppModule);
