import React from 'react';

export default function ContactPage() {
  return (
    <div>
      <h1>Contact Me</h1>
      <p>I'd love to hear from you! Here's how you can reach me:</p>

      <div className="contact-methods">
        <div className="contact-card">
          <h2>Email</h2>
          <p>your.email@example.com</p>
        </div>

        <div className="contact-card">
          <h2>Social Media</h2>
          <div className="social-links">
            <a href="#" target="_blank" rel="noopener noreferrer">GitHub</a>
            <a href="#" target="_blank" rel="noopener noreferrer">LinkedIn</a>
            <a href="#" target="_blank" rel="noopener noreferrer">Twitter</a>
          </div>
        </div>

        <div className="contact-card">
          <h2>Location</h2>
          <p>Singapore</p>
        </div>
      </div>

      <style>{`
        .contact-methods {
          display: grid;
          gap: 1.5rem;
          margin-top: 2rem;
        }
        .contact-card {
          padding: 1.5rem;
          background: rgba(45, 36, 56, 0.7);
          border: 1px solid var(--border-color);
          border-radius: 12px;
          transition: transform 0.3s ease;
          position: relative;
          overflow: hidden;
        }
        .contact-card::before {
          content: '❀';
          position: absolute;
          top: -10px;
          right: -10px;
          font-size: 2rem;
          color: var(--gradient-1);
          opacity: 0.1;
        }
        .contact-card:hover {
          transform: translateY(-3px);
        }
        .contact-card h2 {
          margin-bottom: 0.5rem;
          color: var(--gradient-1);
        }
        .social-links {
          display: flex;
          gap: 1rem;
        }
        .social-links a {
          color: var(--text-color);
          text-decoration: none;
          position: relative;
        }
        .social-links a::after {
          content: '';
          position: absolute;
          width: 0;
          height: 2px;
          bottom: -4px;
          left: 0;
          background: linear-gradient(90deg, var(--gradient-1), var(--gradient-2));
          transition: width 0.3s ease;
        }
        .social-links a:hover::after {
          width: 100%;
        }
        @media (min-width: 768px) {
          .contact-methods {
            grid-template-columns: repeat(3, 1fr);
          }
        }
      `}</style>
    </div>
  );
}