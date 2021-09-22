/**
 * 
 */
var fileTypes = ['json', 'xml'];
function print1()
{
  var str= document.getElementById("up").value;
  document.write(str);
  console.log(str);
}
function readURL(input) {
    if (input.files && input.files[0]) {
        var extension = input.files[0].name.split('.').pop().toLowerCase(),
            isSuccess = fileTypes.indexOf(extension) > -1;

        if (isSuccess) {
            var reader = new FileReader();
            reader.onload = function (e) {
                if (extension == 'json') {
                    $(input).closest('.fileUpload').find(".icon").attr('src', '../images/json-file-svgrepo-com.svg');
                }
                else if (extension == 'xml') {
                    $(input).closest('.fileUpload').find(".icon").attr('src', '../images/xml-svgrepo-com.svg');
                }

                else {
                    $(input).closest('.uploadDoc').find(".docErr").slideUp('slow');
                }
            }

          var url= reader.readAsDataURL(input.files[0]);
          var str= document.getElementById("up").value;
          console.log(str);
        }
        else {
            $(input).closest('.uploadDoc').find(".docErr").fadeIn();
            setTimeout(function () {
                $('.docErr').fadeOut('slow');
            }, 9000);
        }
    }
}
$(document).ready(function () {

    $(document).on('change', '.up', function () {
        var id = $(this).attr('id');
        var profilePicValue = $(this).val();
        var fileNameStart = profilePicValue.lastIndexOf('\\');
        profilePicValue = profilePicValue.substr(fileNameStart + 1).substring(0, 20);
        if (profilePicValue != '') {
            $(this).closest('.fileUpload').find('.upl').html(profilePicValue);
        }
    });

    $(".btn-new").on('click', function () {
        $("#uploader").append('<div class="row uploadDoc"><div class="col-sm-3"><div class="docErr">Please upload valid file</div><!--error--><div class="fileUpload btn btn-orange"> <img src="https://image.flaticon.com/icons/svg/136/136549.svg" class="icon"><span class="upl" id="upload">Upload document</span><input type="file" class="upload up" id="up" onchange="readURL(this);" /></div></div><div class="col-sm-8"><input type="text" class="form-control" name="" placeholder="Note"></div><div class="col-sm-1"><a class="btn-check"><i class="fa fa-times"></i></a></div></div>');
    });

    $(document).on("click", "a.btn-check", function () {
        if ($(".uploadDoc").length > 1) {
            $(this).closest(".uploadDoc").remove();
        } else {
            alert("You have to upload at least one document.");
        }
    });
});