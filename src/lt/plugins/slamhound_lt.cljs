(ns lt.plugins.slamhound-lt
  (:require [lt.object :as object]
            [lt.objs.editor :as editor]
            [lt.objs.editor.pool :as pool]
            [lt.objs.notifos :as notifos]
            [lt.objs.command :as cmd])
  (:require-macros [lt.macros :refer [defui behavior]]))

(defn slamhound-str
  [path]
  (str "(do (require 'slam.hound)"
       "(binding [clojure.pprint/*print-right-margin* 80]"
       "(let [file (java.io.File. \"" path "\")]"
       "(slam.hound/swap-in-reconstructed-ns-form file))))"))

(cmd/command {:command ::slamhound
              :desc "slamhound-lt: Reconstruct namespace"
              :exec (fn []
                      (when-let [ed (pool/last-active)]
                        (let [path (:path (:info @ed))
                              exp (slamhound-str path)]

                          (notifos/set-msg! (str "Running slamhound on " path))
                          (object/raise ed
                                        :eval.custom
                                        exp
                                        {:result-type :inline :verbatim true}))))})
