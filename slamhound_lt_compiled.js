if(!lt.util.load.provided_QMARK_('lt.plugins.slamhound-lt')) {
goog.provide('lt.plugins.slamhound_lt');
goog.require('cljs.core');
goog.require('lt.objs.notifos');
goog.require('lt.objs.notifos');
goog.require('lt.objs.editor.pool');
goog.require('lt.objs.command');
goog.require('lt.objs.editor');
goog.require('lt.object');
goog.require('lt.object');
goog.require('lt.objs.editor');
goog.require('lt.objs.editor.pool');
goog.require('lt.objs.command');
lt.plugins.slamhound_lt.slamhound_str = (function slamhound_str(path){return [cljs.core.str("(do (require 'slam.hound)"),cljs.core.str("(binding [clojure.pprint/*print-right-margin* 80]"),cljs.core.str("(let [file (java.io.File. \""),cljs.core.str(path),cljs.core.str("\")]"),cljs.core.str("(slam.hound/swap-in-reconstructed-ns-form file))))")].join('');
});
lt.objs.command.command.call(null,new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"command","command",1964298941),new cljs.core.Keyword("lt.plugins.slamhound-lt","slamhound","lt.plugins.slamhound-lt/slamhound",2679134961),new cljs.core.Keyword(null,"desc","desc",1016984067),"slamhound-lt: Reconstruct namespace",new cljs.core.Keyword(null,"exec","exec",1017031683),(function (){var temp__4092__auto__ = lt.objs.editor.pool.last_active.call(null);if(cljs.core.truth_(temp__4092__auto__))
{var ed = temp__4092__auto__;var path = new cljs.core.Keyword(null,"path","path",1017337751).cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"info","info",1017141280).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,ed)));var exp = lt.plugins.slamhound_lt.slamhound_str.call(null,path);lt.objs.notifos.set_msg_BANG_.call(null,[cljs.core.str("Running slamhound on "),cljs.core.str(path)].join(''));
return lt.object.raise.call(null,ed,new cljs.core.Keyword(null,"eval.custom","eval.custom",3328560245),exp,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"result-type","result-type",4725630556),new cljs.core.Keyword(null,"inline","inline",4124874251),new cljs.core.Keyword(null,"verbatim","verbatim",3307884968),true], null));
} else
{return null;
}
})], null));
}

//# sourceMappingURL=slamhound lt_compiled.js.map