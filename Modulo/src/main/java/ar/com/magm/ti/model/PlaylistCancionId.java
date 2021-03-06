package ar.com.magm.ti.model;
// Generated 08/11/2017 23:33:49 by Hibernate Tools 4.3.1



/**
 * PlaylistCancionId generated by hbm2java
 */
public class PlaylistCancionId  implements java.io.Serializable {


     private int idPlaylist;
     private int idCancion;

    public PlaylistCancionId() {
    }

    public PlaylistCancionId(int idPlaylist, int idCancion) {
       this.idPlaylist = idPlaylist;
       this.idCancion = idCancion;
    }
   
    public int getIdPlaylist() {
        return this.idPlaylist;
    }
    
    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
    public int getIdCancion() {
        return this.idCancion;
    }
    
    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PlaylistCancionId) ) return false;
		 PlaylistCancionId castOther = ( PlaylistCancionId ) other; 
         
		 return (this.getIdPlaylist()==castOther.getIdPlaylist())
 && (this.getIdCancion()==castOther.getIdCancion());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPlaylist();
         result = 37 * result + this.getIdCancion();
         return result;
   }   


}


