import React, { useState } from 'react';

export default function HomePage() {
  const [selectedFile, setSelectedFile] = useState<File | null>(null);
  const [uploadStatus, setUploadStatus] = useState<string>('');

  const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const file = event.target.files?.[0];
    if (file) {
      setSelectedFile(file);
      setUploadStatus('');
    }
  };

  const handleUpload = async (event: React.FormEvent) => {
    event.preventDefault();
    if (!selectedFile) {
      setUploadStatus('Please select a file first');
      return;
    }

    // Simulated upload - in a real app, you'd send to a server
    setUploadStatus('Uploading...');
    await new Promise(resolve => setTimeout(resolve, 1500));
    setUploadStatus('Document uploaded successfully!');
    setSelectedFile(null);
    
    // Reset the file input
    const fileInput = document.getElementById('fileInput') as HTMLInputElement;
    if (fileInput) fileInput.value = '';
  };

  return (
    <div>
      <h1>Welcome to My Blog</h1>
      <p>Hello! I'm Belinda, a developer based in Singapore. This is my personal space where I share my thoughts, experiences, and journey.</p>
      
      <div className="upload-section">
        <h2>Upload Document</h2>
        <form onSubmit={handleUpload} className="upload-form">
          <div className="file-input-container">
            <input
              type="file"
              id="fileInput"
              onChange={handleFileChange}
              className="file-input"
              accept=".pdf,.doc,.docx,.txt"
            />
            <label htmlFor="fileInput" className="file-label">
              {selectedFile ? selectedFile.name : 'Choose a file'}
            </label>
          </div>
          
          <button 
            type="submit" 
            className="upload-button"
            disabled={!selectedFile}
          >
            Upload Document
          </button>
          
          {uploadStatus && (
            <div className={`status-message ${uploadStatus.includes('success') ? 'success' : ''}`}>
              {uploadStatus}
            </div>
          )}
        </form>
      </div>

      <style>{`
        .upload-section {
          margin-top: 2rem;
          padding: 2rem;
          background: rgba(45, 36, 56, 0.7);
          border: 1px solid var(--border-color);
          border-radius: 12px;
          position: relative;
          overflow: hidden;
        }
        .upload-section::before {
          content: '❀';
          position: absolute;
          top: 1rem;
          right: 1rem;
          font-size: 2rem;
          color: var(--gradient-1);
          opacity: 0.1;
        }
        h2 {
          margin-bottom: 1.5rem;
          color: var(--gradient-1);
          font-size: 1.8rem;
        }
        .upload-form {
          display: flex;
          flex-direction: column;
          gap: 1.5rem;
        }
        .file-input-container {
          position: relative;
          width: 100%;
        }
        .file-input {
          position: absolute;
          width: 100%;
          height: 100%;
          opacity: 0;
          cursor: pointer;
          z-index: 2;
        }
        .file-label {
          display: block;
          padding: 1rem;
          background: rgba(255, 158, 205, 0.1);
          border: 2px dashed var(--gradient-1);
          border-radius: 8px;
          text-align: center;
          cursor: pointer;
          transition: all 0.3s ease;
        }
        .file-label:hover {
          background: rgba(255, 158, 205, 0.2);
        }
        .upload-button {
          padding: 0.8rem 1.5rem;
          background: linear-gradient(45deg, var(--gradient-1), var(--gradient-2));
          border: none;
          border-radius: 8px;
          color: var(--bg-color);
          font-weight: bold;
          cursor: pointer;
          transition: opacity 0.3s ease;
        }
        .upload-button:disabled {
          opacity: 0.5;
          cursor: not-allowed;
        }
        .upload-button:not(:disabled):hover {
          opacity: 0.9;
        }
        .status-message {
          padding: 1rem;
          border-radius: 8px;
          background: rgba(255, 158, 205, 0.1);
          text-align: center;
        }
        .status-message.success {
          background: rgba(177, 140, 254, 0.1);
          color: var(--gradient-2);
        }
      `}</style>
    </div>
  );
}