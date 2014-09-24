(ns bob
  (:require [clojure.string :as string]))

(defn- silence? [stmt]
  (string/blank? stmt))

(defn- question? [stmt]
  (= \? (last stmt)))

(defn- has-letter? [stmt]
  (some #(or (Character/isUpperCase %)
             (Character/isLowerCase %)) stmt))

(defn- shouting? [stmt]
  (and (= stmt (string/upper-case stmt))
       (has-letter? stmt)))

(defn response-for 
  "Generates Bob's response to a given stmt."
  [stmt]
  (cond
    (silence? stmt) "Fine. Be that way!"
    (shouting? stmt) "Woah, chill out!"
    (question? stmt) "Sure."
    :else "Whatever."))

