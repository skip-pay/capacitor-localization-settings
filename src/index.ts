import { registerPlugin } from '@capacitor/core';

import type { LocalizationSettingsPlugin } from './definitions';

const LocalizationSettings = registerPlugin<LocalizationSettingsPlugin>(
  'LocalizationSettings',
  {
    web: () => import('./web').then(m => new m.LocalizationSettingsWeb()),
  },
);

export * from './definitions';
export { LocalizationSettings };
