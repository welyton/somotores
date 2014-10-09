function handleSubmit(xhr, status, args, dialog) {
    var jqDialog = jQuery('#'+dialog.id);
    if(args.validationFailed) {
        jqDialog.effect('shake', { times:3 }, 100);
    } else {
        dialog.hide();
    }
}

function handleLoginRequest(xhr, status, args) {
    if(args.validationFailed || !args.logado) {
        jQuery('#formLogin').effect("shake", {times:5}, 100);
    }
    else {
      location.href =args.rota;
    }
}