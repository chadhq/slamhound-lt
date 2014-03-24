(ns lt.plugins.slamhound-lt
  (:require [lt.object :as object]
            [lt.objs.editor :as editor]
            [lt.objs.editor.pool :as pool]
            [lt.objs.notifos :as notifos]
            [lt.objs.command :as cmd]
            [lt.plugins.paredit :as par])
  (:require-macros [lt.macros :refer [defui behavior]]))

(defn sl-str
  [path]
  (str     "(do (require 'slam.hound)"
           "(binding [clojure.pprint/*print-right-margin* 90]"
           "(let [file (java.io.File. \"" path "\")]"
           "(slam.hound/swap-in-reconstructed-ns-form file))))"))

(cmd/command {:command ::slamhound
              :desc "slamhound-lt: Replace"
              :exec (fn []

                      (when-let [ed (pool/last-active)]
                        (let [path (:path (:info @ed))
                              exp (sl-str path)]

                          (notifos/set-msg! (str "Running slamhound on " path))
                          (object/raise ed
                                        :eval.custom
                                        exp
                                        {:result-type :inline :verbatim true}))))})


;; (cmd/command {:command ::slamhound-preview
;;               :desc "slamhound-lt: Preview"
;;               :exec (fn []
;;                       (when-let [ed (pool/last-active)]
;;                         (let [path (:path (:info @ed))
;;                               exp (slamhound-expression path)]


;;                           (let [cur (pool/last-active)]
;;                             (editor/move-cursor cur {:ch 0
;;                                                      :line 0}))

;;                           (object/raise ed
;;                                         :eval.custom
;;                                         exp
;;                                         {:result-type :inline :verbatim true}
;;                                         ))))})

;; (cmd/command {:command ::slamhound-re
;;               :desc "slamhound-lt: Recursive Select"
;;               :exec (fn [] (when-let [ed (pool/last-active)]
;;                         (let [path (:path (:info @ed))
;;                               exp (slamhound-expression path)]

;;                           (cmd/exec! :paredit.select.parent)
;;                           )))})


;; (defn me-expression [exp] (str "(macroexpand '" exp ")" ))

;; (cmd/command {:command ::macro-expand
;;               :desc "macro-expand: Expand"
;;               :exec (fn [] (when-let [ed (pool/last-active)]
;;                              (cmd/exec! :paredit.select.parent)
;;                              (let [path (:path (:info @ed))
;;                                    exp (me-expression (editor/selection ed))]

;;                                (notifos/set-msg! (str "Running slamhound on " exp))


;;                                (object/raise ed
;;                                              :eval.custom
;;                                              exp
;;                                              {:result-type :inline :verbatim true}))))})
