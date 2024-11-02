import React from 'react';

export default function AboutPage() {
  return (
    <div>
      <h1>About Me</h1>
      <div className="about-content">
        <img src="https://via.placeholder.com/150" alt="Belinda" className="profile-image" />
        <div className="bio">
          <p>Hi, I'm Belinda from Singapore! I'm passionate about technology and development.</p>
          
          <h2>Background</h2>
          <p>I'm a developer who loves building things for the web. When I'm not coding, you can find me exploring new technologies and sharing my knowledge with others.</p>
          
          <h2>Skills</h2>
          <ul>
            <li>Web Development</li>
            <li>Problem Solving</li>
            <li>Technical Writing</li>
          </ul>
        </div>
      </div>

      <style>{`
        .about-content {
          display: grid;
          gap: 2rem;
          margin-top: 1rem;
        }
        .profile-image {
          border-radius: 50%;
          max-width: 150px;
          margin: 0 auto;
          border: 3px solid var(--gradient-1);
          padding: 3px;
          background: linear-gradient(45deg, var(--gradient-1), var(--gradient-2));
        }
        .bio {
          max-width: 600px;
          padding: 1.5rem;
          background: rgba(45, 36, 56, 0.7);
          border-radius: 12px;
          border: 1px solid var(--border-color);
        }
        h2 {
          margin: 1.5rem 0 0.5rem 0;
          color: var(--gradient-1);
          font-size: 1.5rem;
        }
        ul {
          list-style: none;
          margin-left: 1rem;
        }
        li {
          margin-bottom: 0.5rem;
          position: relative;
          padding-left: 1.5rem;
        }
        li::before {
          content: '❀';
          position: absolute;
          left: 0;
          color: var(--gradient-1);
        }
        @media (min-width: 768px) {
          .about-content {
            grid-template-columns: auto 1fr;
          }
        }
      `}</style>
    </div>
  );
}