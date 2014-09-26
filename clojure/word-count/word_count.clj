(ns word-count)

(defn word-count [s]
  (reduce #(assoc %1 %2 (inc (%1 %2 0)))
          {}
          (re-seq #"\w+" (.toLowerCase s))))
