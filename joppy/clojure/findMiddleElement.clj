;; Given a singly linked list, find its middle element. If there are an even number of nodes, then there are two middle nodes; return the second middle element in cases like this.

;; Example

;;     For l = [5, 4, 3, 2, 1], the output should be findMiddleElement(l) = 3;
;;     For l = [10, 8, 6, 4, 2, 0], the output should be findMiddleElement(l) = 4.

;; Singly-linked lists are already defined with this interface:
;; (defrecord ListNode [value next])
;;
(defn single-linked-list-to-seq [l]
  (loop [value (:value l)
         next (:next l)
         sequence []]
    (if (nil? next)
      (conj sequence value)
      (recur (:value next) (:next next) (conj sequence value))))
  )

(defn findMiddleElement [l] 
  (let [l-sequence (single-linked-list-to-seq l)]
    (first 
     (drop 
      (if (even? (count l-sequence)) 
        (/ (count l-sequence) 2) 
        (/ (dec (count l-sequence)) 2)) l-sequence)))
  )
        
;; works with normal sequences        
;;(defn findMiddleElement [l] 
    ;;(first 
      ;;  (drop 
        ;;    (if (even? (count l)) 
          ;;      (/ (count l) 2) 
            ;;    (/ (dec (count l)) 2)) l))
                ;;)
