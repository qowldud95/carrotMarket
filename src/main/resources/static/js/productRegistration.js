
/*
function setThumbnail(event){

    var reader = new FileReader();


    reader.onload = function(event) {
        var image = document.createElement("image");
        image.setAttribute("src", event.target.result);
        document.querySelector(".image_container").appendChild(image);
    };

    reader.readAsDataURL(event.target.files[0]);

}
*/

function setThumbnail(event){
    for (var img of event.target.files) {
        var reader = new FileReader();


        reader.onload = function (event) {
            var image = document.createElement("img");
            image.setAttribute("src", event.target.result);
            image.setAttribute("class","image_value" );
            document.querySelector(".image_container").appendChild(image);
        };
        console.log(img);
        reader.readAsDataURL(img);

    }
}