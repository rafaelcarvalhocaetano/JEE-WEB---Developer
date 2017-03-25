function verificar(xhr, status, args, dlg, tbl) {
	if (args.validationFailed) {
		PF(dlg).jq.effect("shake", {
			times : 5
		}, 200);
	} else {
		PF(dlg).hide();
		PF(tbl).clearFilters();
	}
}
