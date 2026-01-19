import tensorflow as tf
import time
import numpy as np

# ---- 1. Load pretrained model ----
model = tf.keras.models.load_model("model.h5")

# ---- 2. Baseline evaluation ----
def measure_inference(model):
    dummy = np.random.rand(1, 224, 224, 3).astype("float32")
    start = time.time()
    model.predict(dummy)
    end = time.time()
    return end - start

baseline_latency = measure_inference(model)

# Convert to TFLite (full precision)
converter = tf.lite.TFLiteConverter.from_keras_model(model)
tflite_fp_model = converter.convert()

with open("model_fp.tflite", "wb") as f:
    f.write(tflite_fp_model)

# ---- 3. Apply quantization (8-bit) ----
converter.optimizations = [tf.lite.Optimize.DEFAULT]
tflite_quant = converter.convert()

with open("model_quant.tflite", "wb") as f:
    f.write(tflite_quant)

# ---- 4. Final size comparison ----
fp_size = len(tflite_fp_model)
quant_size = len(tflite_quant)

print("Baseline latency:", baseline_latency)
print("Model FP32 size:", fp_size, "bytes")
print("Model INT8 size:", quant_size, "bytes")
