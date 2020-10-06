(ns fff.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn past-end?
  [index, numbers]
  (== (count numbers) index))

(defn get-two-indices-for-sum
  ([numbers target] (get-two-indices-for-sum numbers target 0 1))
  ([numbers target first-index gap]
   (if (past-end? first-index numbers)
     []
     (let [second-index (+ first-index gap)]
       (if (past-end? second-index numbers)
         (recur numbers target (inc first-index) 1)
         (if (= target (+ (numbers first-index) (numbers second-index)))
           [first-index second-index]
           (recur numbers target first-index (inc gap))))))))

(get-two-indices-for-sum [1 2 3 4] 5)

