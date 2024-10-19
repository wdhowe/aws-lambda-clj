(ns handler)

(defn process-event
  "Sample fn to process an event."
  [event]
  (get-in event [:detail :my-data] "done"))

(defn handler
  "Entrypoint for the lambda function."
  [event _context]
  (prn {:msg "Invoked with event",
        :event event})
  (process-event event))
