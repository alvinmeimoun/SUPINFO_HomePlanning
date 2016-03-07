var table_messages;
$(document).ready(function() {
    $("#tabs").tabs();
    $("#input-planning-file").fileinput({
        showUpload: false,
        showRemove: false,
        showPreview: false,
        allowedFileExtensions : ['csv']
    });

    table_messages = $("#table_messages").DataTable( {
        pageLength: 10,
        scrollCollapse: true,
        paging:         false,
        searching: false
    } );

    //Add message dialog
    var dialog = $( "#popup_add_msg" ).dialog({
        autoOpen: false,
        height: 180,
        width: 350,
        modal: true,
        buttons: {
            "Add message": function(){
                document.getElementById("form_new_message").submit();
            },
            Cancel: function() {
                dialog.dialog( "close" );
            }
        },
        close: function() {
            form[ 0 ].reset();
        }
    });

    $( "#bt_add_message" ).button().on( "click", function() {
        dialog.dialog( "open" );
    });
} );

function deleteMessage(element){
    var row = element.parentNode.parentNode;
    var cells = row.getElementsByTagName("td");
    var msgId = cells[0].innerText;

    $.ajax({
        url: "/api/admin/message/delete",
        type: 'GET',
        async: false,
        data: { messageId: msgId },
        success: function(data){
            row.remove().draw( false );
        },
        error: function(){
            alert('An error has occured');
        }
    })
}

function getCookie(name){
    var pattern = RegExp(name + "=.[^;]*")
    matched = document.cookie.match(pattern)
    if(matched){
        var cookie = matched[0].split('=')
        return cookie[1]
    }
    return false
}