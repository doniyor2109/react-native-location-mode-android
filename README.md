# react-native-location-mode-android
Provides information about location mode for android

## Install

Download package

```javascript
npm install react-native-location-mode-android --save
```

Link plugin files
```javascript
react-native link react-native-location-mode-android
```


## Usage

### Get phone's location mode
```javascript
import LocationMode from 'react-native-location-mode-android';

LocationMode.getMode().then((mode) => {
  console.log(mode); // -> can be one of LOCATION_OFF, HIGH_ACCURACY, DEVICE_ONLY, BATTERY_SAVE
});

```

### Get check specific mode

```javascript
import LocationMode from 'react-native-location-mode-android';

LocationMode.isHighAccuracy().then((result) => {
  console.log(result); // -> boolean
});

```
