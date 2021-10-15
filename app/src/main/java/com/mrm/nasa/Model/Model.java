/*

    {
      "photos":[
      {
         "id":840983,
         "sol":3137,
         "camera":{
            "id":26,
            "name":"NAVCAM",
            "rover_id":5,
            "full_name":"Navigation Camera"
         },
         "img_src":"https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/03137/opgs/edr/ncam/NRB_675974688EDR_S0880804NCAM00594M_.JPG",
         "earth_date":"2021-06-03",
         "rover":{
            "id":5,
            "name":"Curiosity",
            "landing_date":"2012-08-06",
            "launch_date":"2011-11-26",
            "status":"active"
         }
      },
      {
         "id":840984,
         "sol":3137,
         "camera":{
            "id":26,
            "name":"NAVCAM",
            "rover_id":5,
            "full_name":"Navigation Camera"
         },
         "img_src":"https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/03137/opgs/edr/ncam/NRB_675975192EDR_M0880804NCAM00580M_.JPG",
         "earth_date":"2021-06-03",
         "rover":{
            "id":5,
            "name":"Curiosity",
            "landing_date":"2012-08-06",
            "launch_date":"2011-11-26",
            "status":"active"
         }
      }
   ]
}


https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2015-6-3&api_key=9ZgzamRGiD9dLROoWeaHXcQUPIgPYzfPxhy5Ft60

 */

package com.mrm.nasa.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

}