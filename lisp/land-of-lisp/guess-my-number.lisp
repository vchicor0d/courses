(defparameter *small* 1) ;; Parametro (Variable modificable), nombre entre * por convención
(defparameter *big* 100)

(defun guess-my-number ()
  (ash (+ *small* *big*) -1)) ;; ash añade o quita la cifra menos significativa de un numero en binario

(defun smaller ()
  (setf *big* (1- (guess-my-number))) ;; setf setea un parametro, 1- resta 1
  (guess-my-number))

(defun bigger ()
  (setf *small* (1+ (guess-my-number))) ;; 1+, suma 1
  (guess-my-number))

(defun start-over ()
  (defparameter *small* 1)
  (defparameter *big* 100)
  (guess-my-number))
