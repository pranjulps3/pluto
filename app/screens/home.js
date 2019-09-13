import React, { useState } from 'react';
import { Image, Text, View, StyleSheet, NativeModules } from 'react-native';
import { Button } from 'react-native-elements';
import NetInfo from '@react-native-community/netinfo';

const networkScanner = NativeModules.ScanNetwork;

export function Home () {

    const [ scanning, setScanning ] = useState(false); 
    const buttonText = scanning ? 'Stop Exploring' : 'Explore';

    function handleScanBtnPress () {
        if(!scanning) {
            setScanning(true);
            NetInfo.fetch().then(state => {
                if(state.type != 'wifi') {
                    setScanning(false);
                    alert('You must be connected to wifi');
                } else {
                    alert(networkScanner.getPrivateIP);
                    networkScanner.getPrivateIP(f => f, ip => {
                        alert(`Your IPAddress is: ${ip}`)
                    })
                }
            })
        } else {
            setScanning(false);
        }
    }

    return (
        <View style={style.homeContainer}>
            <View style={style.imageContainer}>
                <Image
                    source={require('../../assets/pluto-home.png')}
                    style={style.plutoImage}
                />
                <Text style={{fontSize: 30}}>Pluto</Text>
            </View>
            <View style={style.scanButtonContainer}>
                <Button
                    onPress={handleScanBtnPress}
                    style={style.scanButton}
                    type="solid"
                    title={buttonText}
                    raised
                />
            </View>
        </View>
    );
};

const style = StyleSheet.create({
    homeContainer: {
        flex: 1,
        height: '100%'
    },
    imageContainer: {
        flex: 3,
        alignItems: 'center',
        justifyContent: 'center'
    },
    plutoImage: {
        width: 200,
        height: 200,
        overlayColor: 'white',
        borderRadius: 100,
        borderColor: 'black',
        borderWidth: 10
    },
    scanContainer: {
        flex: 1,
        justifyContent: 'flex-end'
    },
    scanButton: {
        marginBottom: 'auto'
    }
})