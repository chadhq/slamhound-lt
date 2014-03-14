(ns lt.plugins.slamhound-lt
  (:require [lt.object :as object]
            [lt.objs.editor :as editor]
            [lt.objs.editor.pool :as pool]
            [lt.objs.notifos :as notifos]
            [lt.objs.command :as cmd])
  (:require-macros [lt.macros :refer [defui behavior]]))

(defn slamhound-expression [path] (str "(do (require 'slam.hound)(slam.hound/reconstruct \"" path "\"))" ))

(cmd/command {:command ::slamhound
              :desc "slamhound-lt: Preview"
              :exec (fn []
                      (when-let [ed (pool/last-active)]
                        (let [path (:path (:info @ed))
                              exp (slamhound-expression path)]
                          (notifos/set-msg! (str "Running slamhound on " exp))

                          (let [cur (pool/last-active)]
                            (editor/move-cursor cur {:ch 0
                                                     :line 0}))

                          (object/raise ed
                                        :eval.custom
                                        exp
                                        {:result-type :inline :verbatim true}
                                        )

                          (notifos/set-msg! "Slamhound done."))))})

;; (defui doc-ui [result]
;;   [:div.inline-doc
;;    [:h1 "SlAmHoUnD"]])
