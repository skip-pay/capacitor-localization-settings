export interface LocalizationSettingsPlugin {
  getLanguage(): Promise<{ value: string }>;
  setLanguage(options: { value: string }): Promise<{ value: string }>;
}
