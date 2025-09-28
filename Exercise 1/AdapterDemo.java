package com.patterns.structural.adapter;

// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee
class AdvancedMediaPlayer {
    void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
    void playAvi(String fileName) {
        System.out.println("Playing AVI file: " + fileName);
    }
}

// Adapter
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("avi")) {
            advancedPlayer.playAvi(fileName);
        } else {
            System.out.println("Unsupported format: " + audioType);
        }
    }
}

// Concrete Player
class AudioPlayer implements MediaPlayer {
    private MediaAdapter adapter;

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            adapter = new MediaAdapter();
            adapter.play(audioType, fileName);
        }
    }
}

// Demo
public class AdapterDemo {
    public static void runDemo() {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("mp4", "movie.mp4");
        player.play("avi", "video.avi");
    }
}
