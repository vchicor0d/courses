;; You have two triangles A1B1C1 and A2B2C2 on a plane. Your task is to determine whether they are rather similar, i.e. if their corresponding angles have the same measurements.

;; In order for two triangles to be rather similar, the following equations must be true:

;;     angle(A1B1, B1C1) = angle(A2B2, B2C2)
;;     angle(A1C1, C1B1) = angle(A2C2, C2B2)
;;     angle(B1A1, A1C1) = angle(B2A2, A2C2)
;;     where angle(AB, CD) refers to an angle between segments AB and CD in the triangle.

;; Example

;;     For coordinates = [0, 0, 0, 1, 1, 0, 0, 0, 0, -3, -3, 0], the output should be
;;     areTrianglesSimilar(coordinates) = true.

;;     Both triangles have pairwise equal angles: 90, 45, and 45 degrees.

;;     For coordinates = [0, 0, 0, 1, 1, 0, 0, 0, 0, -4, -2, 0], the output should be
;;     areTrianglesSimilar(coordinates) = false.

;;     The first triangle's angles are 90, 45, and 45 degrees, while the second triangle's angles are 90, 60, and 30 degrees.

;;     For coordinates = [0, 0, 0, 1, 1, 0, -3, 0, 0, -3, 0, 0], the output should be
;;     areTrianglesSimilar(coordinates) = false.

;;     Both triangles have the same sets of degrees, but they are in different order.

;; Input/Output

;;     [execution time limit] 16 seconds (clj)

;;     [input] array.integer coordinates

;;     An array of triangle coordinates. The first 6 elements represent vertices of the first triangle A1B1C1 (coordinates[0] corresponds to the x-coordinate of A1, coordinates[1] to the y-coordinate of A1, etc.). The next 6 elements represent vertices of the second triangle in the same format.

;;     It is guaranteed that the triangles are not degenerate.

;;     Guaranteed constraints:
;;     coordinates.length = 12,
;;     -100 ≤ coordinates[i] ≤ 100.

;;     [output] boolean
;;         Return true if the given triangles are rather similar, otherwise return false.

(defn calcular-pendiente [c1 c2]
    (if (zero? (- (first c2) (first c1)))
        0
        (/ (- (last c2) (last c1)) (- (first c2) (first c1)))))
    
(defn calcular-angulo [pend1 pend2]
    (Math/atan (/ (- pend2 pend1) (inc (* pend1 pend2)))))

(defn areTrianglesSimilar [coordinates] 
    (let [t1coords (take 6 coordinates)
          t2coords (drop 6 coordinates)
          t1s1 (take 2 t1coords)
          t1s2 (take 2 (drop 2 t1coords))
          t1s3 (drop 4 t1coords)
          t2s1 (take 2 t2coords)
          t2s2 (take 2 (drop 2 t2coords))
          t2s3 (drop 4 t2coords)
          pendt1-s1s2 (calcular-pendiente t1s1 t1s2)
          pendt1-s2s3 (calcular-pendiente t1s2 t1s3)
          pendt1-s3s1 (calcular-pendiente t1s3 t1s1)
          pendt2-s1s2 (calcular-pendiente t2s1 t2s2)
          pendt2-s2s3 (calcular-pendiente t2s2 t2s3)
          pendt2-s3s1 (calcular-pendiente t2s3 t2s1)
          t1a1 (calcular-angulo pendt1-s1s2 pendt1-s2s3)
          t1a2 (calcular-angulo pendt1-s2s3 pendt1-s3s1)
          t1a3 (calcular-angulo pendt1-s3s1 pendt1-s1s2)
          t2a1 (calcular-angulo pendt2-s1s2 pendt2-s2s3)
          t2a2 (calcular-angulo pendt2-s2s3 pendt2-s3s1)
          t2a3 (calcular-angulo pendt2-s3s1 pendt2-s1s2)]
          (and (= t1a1 t2a1) (= t1a2 t2a2) (= t1a3 t2a3))))
