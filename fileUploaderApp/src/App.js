import React, { useState } from 'react';
import Dropzone from 'react-dropzone';
import 'bootstrap/dist/css/bootstrap.css';
import Employeetable from './Employeetable/Employeetable';

const App = () => {
  const [file, setFile] = useState(null);

  const handleFileInputChange = (acceptedFiles) => {
    setFile(acceptedFiles[0]);
  };

  const handleFileUpload = async () => {
    const formData = new FormData();
    formData.append('file', file);
    const response = await fetch('http://localhost:8080/upload-csv', {
      method: 'POST',
      body: formData
    });
    const data = await response.json();
    console.log(data);
  };

  return (
    <div className="container mt-5">
      <div className="card">
        <div className="card-header">
          Upload a CSV file
        </div>
        <div className="card-body">
          <Dropzone onDrop={handleFileInputChange} accept=".csv">
            {({getRootProps, getInputProps}) => (
              <div {...getRootProps()} className="dropzone">
                <input {...getInputProps()} />
                {file ? (
                  <p>Selected file: {file.name}</p>
                ) : (
                  <p>Drag and drop a CSV file, or click to select file</p>
                )}
              </div>
            )}
          </Dropzone>
          <button className="btn btn-primary mt-3" onClick={handleFileUpload} disabled={!file}>Upload</button>
          <Employeetable />
        </div>
      </div>
    </div>
  );
};

export default App;
