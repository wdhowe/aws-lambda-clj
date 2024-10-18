(ns handler)

(defn handler
  "Entrypoint for the lambda function."
  [{:keys [name] :or {name "World"} :as event} _context]
  (prn {:msg "Invoked with event",
        :data {:event event}})
  {:greeting (str "Hello " name "!")})
