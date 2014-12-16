package com.example.tingtong;

import java.io.FileInputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
/**
 * ����Ӧ�õ�ԭʼ��Դ�ļ�(assets)
1) ͨ��Context.getAssets()�������AssetManager����
2) ͨ��AssetManager�����openFd(String name)������ָ����ԭ����Դ�ļ��У�����һ��AssetFileDescriptor����
3) ͨ��AssetFileDescriptor��getFileDescriptor()�õ�һ��FileDescriptor����
4) ͨ��public void setDataSource (FileDescriptor fd, long offset, long length)������MediaPlayer����
5) ����MediaPlayer.prepare()����׼����Ƶ
6) ����MediaPlayer��start()��pause()��stop()�ȷ�������
 
AssetFileDescriptor fileDescriptor = assetManager.openFd("a2.mp3");
mediaPlayer = new MediaPlayer();
    mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),
                              fileDescriptor.getStartOffset(),
                              fileDescriptor.getLength());
    mediaPlayer.prepare();
mediaPlayer.start();
 * @author Administrator
 */
public class SensorEventActivity extends Activity implements SensorEventListener,OnClickListener {
	private Button normal,receiver;
	protected AudioManager audioManager;
	protected SensorManager sensorManager;
	protected Sensor sensor;
	protected AssetManager assetManager;
	MediaPlayer mPlayer = new MediaPlayer();
	MediaPlayer mPlayer1 = new MediaPlayer();
	
	
	protected void init() {
		// TODO Auto-generated method stub
		audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
		sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		assetManager = SensorEventActivity.this.getAssets();
		System.out.println(assetManager.toString());
		normal = (Button) findViewById(R.id.normal);
		receiver = (Button) findViewById(R.id.receiver);
//		normal.setOnClickListener(this);
//		receiver.setOnClickListener(this);
		try {
//			FileInputStream file = (FileInputStream) assetManager.open("music/huluwan.mp3");
//			mPlayer.reset();
//			mPlayer.setDataSource(file.getFD());
//			AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
//			mPlayer.setDataSource(afd.getFileDescriptor(),
//									afd.getStartOffset(),
//									afd.getLength());
//			mPlayer.prepare();
//			mPlayer.start();
			AssetManager assetMg= this.getApplicationContext().getAssets();
	        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
	        MediaPlayer mediaPlayer = new MediaPlayer();  
	        mediaPlayer.reset();
	        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
	        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
	        mediaPlayer.prepare();
	        mediaPlayer.start();
//			FileInputStream file = (FileInputStream) assetManager.open("huluwan.mp3");
//			mPlayer1.reset();
//			mPlayer1.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
//			mPlayer1.prepare();
//			mPlayer1.start();
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(SensorEventActivity.class.getSimpleName(), ""+e.getMessage());
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		try {
//			AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
//			mPlayer.setDataSource(afd.getFileDescriptor(),
//					afd.getStartOffset(),
//					afd.getLength());
//			mPlayer.prepare();
//			mPlayer.start();
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		init();
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float range = event.values[0];

		if(range == sensor.getMaximumRange()) {
			Toast.makeText(this, "����ģʽ", Toast.LENGTH_SHORT).show();
			audioManager.setMode(AudioManager.MODE_NORMAL);
//			
//			try {
////				FileInputStream file = (FileInputStream) assetManager.open("music/huluwan.mp3");
////				mPlayer.reset();
////				mPlayer.setDataSource(file.getFD());
////				AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
////				mPlayer.setDataSource(afd.getFileDescriptor(),
////										afd.getStartOffset(),
////										afd.getLength());
////				mPlayer.prepare();
////				mPlayer.start();
//				AssetManager assetMg= this.getApplicationContext().getAssets();
//		        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
//		        MediaPlayer mediaPlayer = new MediaPlayer();  
//		        mediaPlayer.reset();
//		        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
//		        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
//		        mediaPlayer.prepare();
//		        mediaPlayer.start();
////				FileInputStream file = (FileInputStream) assetManager.open("huluwan.mp3");
////				mPlayer1.reset();
////				mPlayer1.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
////				mPlayer1.prepare();
////				mPlayer1.start();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Log.e(SensorEventActivity.class.getSimpleName(), ""+e.getMessage());
//			}
		} else {
			Toast.makeText(this, "��Ͳģʽ", Toast.LENGTH_SHORT).show();
			audioManager.setMode(AudioManager.MODE_IN_CALL);
			
//			try {
////				FileInputStream file = (FileInputStream) assetManager.open("music/huluwan.mp3");
////				mPlayer.reset();
////				mPlayer.setDataSource(file.getFD());
////				AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
////				mPlayer.setDataSource(afd.getFileDescriptor(),
////										afd.getStartOffset(),
////										afd.getLength());
////				mPlayer.prepare();
////				mPlayer.start();
//				AssetManager assetMg= this.getApplicationContext().getAssets();
//		        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
//		        MediaPlayer mediaPlayer = new MediaPlayer();  
//		        mediaPlayer.reset();
//		        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
//		        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
//		        mediaPlayer.prepare();
//		        mediaPlayer.start();
////				FileInputStream file = (FileInputStream) assetManager.open("huluwan.mp3");
////				mPlayer1.reset();
////				mPlayer1.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
////				mPlayer1.prepare();
////				mPlayer1.start();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Log.e(SensorEventActivity.class.getSimpleName(), ""+e.getMessage());
//			}
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		sensorManager.registerListener(SensorEventActivity.this, sensor,
				SensorManager.SENSOR_DELAY_NORMAL);
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		sensorManager.unregisterListener(this);
		super.onPause();
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.normal:
			Toast.makeText(this, "����ģʽ", Toast.LENGTH_SHORT).show();
			audioManager.setMode(AudioManager.MODE_NORMAL);
			try {
//				FileInputStream file = (FileInputStream) assetManager.open("music/huluwan.mp3");
//				mPlayer.reset();
//				mPlayer.setDataSource(file.getFD());
//				AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
//				mPlayer.setDataSource(afd.getFileDescriptor(),
//										afd.getStartOffset(),
//										afd.getLength());
//				mPlayer.prepare();
//				mPlayer.start();
				AssetManager assetMg= this.getApplicationContext().getAssets();
		        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
		        MediaPlayer mediaPlayer = new MediaPlayer();  
		        mediaPlayer.reset();
		        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
		        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
		        mediaPlayer.prepare();
		        mediaPlayer.start();
//				FileInputStream file = (FileInputStream) assetManager.open("huluwan.mp3");
//				mPlayer1.reset();
//				mPlayer1.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
//				mPlayer1.prepare();
//				mPlayer1.start();
			} catch (Exception e) {
				e.printStackTrace();
				Log.e(SensorEventActivity.class.getSimpleName(), ""+e.getMessage());
			}
			break;
		case R.id.receiver:
			Toast.makeText(this, "��Ͳģʽ", Toast.LENGTH_SHORT).show();
			audioManager.setMode(AudioManager.MODE_IN_CALL);
			try {
//				mPlayer.reset();
//				mPlayer.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
//				mPlayer.prepare();
//				mPlayer.start();
				AssetManager assetMg= this.getApplicationContext().getAssets();
		        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
		        MediaPlayer mediaPlayer = new MediaPlayer();  
		        mediaPlayer.reset();
		        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
		        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
		        mediaPlayer.prepare();
		        mediaPlayer.start();
			} catch (Exception e) {
				e.printStackTrace();
				Log.e(SensorEventActivity.class.getSimpleName(), ""+e.getMessage());
			}
			break;
		}
	}

}
