/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        primary: {
          500: 'var(--primary-500)',
          600: 'var(--primary-600)',
          700: 'var(--primary-700)',
        },
        accent: {
          500: 'var(--accent-500)',
          600: 'var(--accent-600)',
        },
        bg: {
          100: 'var(--bg-100)',
          200: 'var(--bg-200)',
        },
        text: 'var(--text)',
        'text-button': 'var(--text-button)',
        'header': 'var(--header)',
      },
    },
  },
  plugins: [],
}

