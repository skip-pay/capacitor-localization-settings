import { WebPlugin } from '@capacitor/core';

import type { LocalizationSettingsPlugin } from './definitions';

export class LocalizationSettingsWeb
  extends WebPlugin
  implements LocalizationSettingsPlugin
{
  async getLanguage(): Promise<{ value: string }> {
    return { value: navigator.language };
  }

  async setLanguage(options: { value: string }): Promise<{ value: string }> {
    return options;
  }
}
