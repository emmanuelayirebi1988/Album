import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Album {
    LinkedList<Song> albumList = new LinkedList();
    private String name;
    private String artist;

    public Album(String albumName, String albumArtist){
        this.artist = albumArtist;
        this.name = albumName;

        addSong(albumName,4.4);

        System.out.println("New album added");
    }

    public LinkedList<Song> getAlbumList(){
         return this.albumList;
    }
    public void addToAlbumList(){
        this.albumList = albumList;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }




    public boolean addSong(String name, Double duration){
        Song song = new Song(name,duration);

              albumList.add(song);
        System.out.println("new song" + name + ": " + duration + "s" +
                " added to album " + this.name);

        return true;

    }



    private Song findSong(String name){
        for (Song checkedSong : this.albumList){
            if (checkedSong.equals(name)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber - 1;
        if ((index > 0) && (index <= this.albumList.size())){

            playlist.add(this.albumList.get(index));
            return true;
        }
        System.out.println("this album does not contain track no:" + trackNumber);
        return false;
    }

    //LinkedList<Song> playlist
    public boolean addToPlaylist(String songTittle, LinkedList<Song> playlist){
        Song checkedSong = findSong(songTittle);
        if (checkedSong != null){
            playlist.add(checkedSong);
            System.out.println("Song " + songTittle + " added to playlist");
            return true;
        }
        System.out.println("Can not find song");
        return false;
    }



    public class Song  {

        private String name;
        private double duration; // duration in second

        public Song(String name, double duration) {
            this.name = name;
            this.duration = duration;

            System.out.println(" new song added: " + name + "/ " + duration);
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public double getDuration(){
            return duration;
        }

        public void setDuration(int duration){
             this.duration = duration;
        }

        @Override

        public String toString(){
            return this.name +": " + this.duration;
        }

    }

}




