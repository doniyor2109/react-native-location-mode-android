import { NativeModules } from 'react-native';

const RNLocationModeAndroid = NativeModules.RNLocationModeAndroid;

const getMode = () => {
  return RNLocationModeAndroid.getMode();
};

const isHighAccuracyMode = async () => await getMode() === RNLocationModeAndroid.HIGH_ACCURACY;

const isDeviceOnlyMode = async () => await getMode() === RNLocationModeAndroid.DEVICE_ONLY;

const isBatterySavingMode = async () => await getMode() === RNLocationModeAndroid.BATTERY_SAVING;

const isEnabled = async () => await getMode() !== RNLocationModeAndroid.LOCATION_OFF;


export default {
  getMode,
  isBatterySavingMode,
  isDeviceOnlyMode,
  isHighAccuracyMode,
  isEnabled,
};