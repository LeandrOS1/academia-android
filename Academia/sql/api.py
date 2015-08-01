#!flask/bin/python
from flask import Flask, jsonify
from flask import make_response
from flask import request
from flask import url_for


app = Flask(__name__)


@app.route('/curso-android/api/v1.0/notas', methods=['GET'])
def index():
    return "El GET no es utilizado."

@app.route('/curso-android/api/v1.0/notas', methods=['POST'])
def obtener_notas():
    if not request.json or not 'alumnos' in request.json:
        abort(400)
    
    alumnos = request.json['alumnos']
    suma = promedio = 0
    for alumno in alumnos:
        suma = suma + alumno['nota']

    if suma != 0:   
        promedio = suma / len(alumnos)    
    
    return jsonify({'media': str(promedio)}), 201


@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)



if __name__ == '__main__':
    app.run(host= '0.0.0.0', debug=True)