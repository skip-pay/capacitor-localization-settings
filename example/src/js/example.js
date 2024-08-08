import { LocalizationSettings } from '@skippay/capacitor-localization-settings';

window.testGetLanguage = () => {
  LocalizationSettings.getLanguage().then(result => {
    alert(result.value);
  });
};

window.testSetLanguage = () => {
  LocalizationSettings.setLanguage({ value: 'en-US' });
};
