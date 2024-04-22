// programa escrito para placas Arduino que utiliza el lenguaje de programación Arduino
const int trigPin = 2;
const int echoPin = 3;
const int motorPin = 4;
unsigned long previousMillis = 0;
const long interval = 500;  // Intervalo de medición en milisegundos

void setup() {
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(motorPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  unsigned long currentMillis = millis();

  // Medir cada intervalo definido
  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;

    // Genera un pulso en el pin TRIG del sensor de ultrasonidos
    digitalWrite(trigPin, LOW);
    delayMicroseconds(2);
    digitalWrite(trigPin, HIGH);
    delayMicroseconds(10);
    digitalWrite(trigPin, LOW);

    // Mide el tiempo que tarda en recibir el eco
    long duration = pulseIn(echoPin, HIGH);
    // Calcula la distancia basada en la velocidad del sonido
    int distance = duration * 0.0343 / 2;
    // Activa el motor vibratorio si se detecta un objeto a menos de 500 cm (5 metros)
    if (distance > 0 && distance <= 500) {
      digitalWrite(motorPin, HIGH);
      delay(1000);
      digitalWrite(motorPin, LOW);
    }

    // Imprime la distancia en el monitor serie
    Serial.print("Distance: ");
    Serial.print(distance);
    Serial.println(" cm");
  }
}


