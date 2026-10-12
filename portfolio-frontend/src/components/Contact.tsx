import { useState } from "react"
import type { ContactMessage } from "../types/ContactMessage"

function Contact() {

  const [form, setForm] = useState<ContactMessage>({
    name: "",
    email: "",
    subject: "",
    message: ""
  })

  const [sent, setSent] = useState(false)

  const handleChange = (
    event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {

    setForm({
      ...form,
      [event.target.name]: event.target.value
    })
  }

  const handleSubmit = async (
    event: React.FormEvent<HTMLFormElement>
  ) => {

    event.preventDefault()

    const response = await fetch(
      "http://localhost:8080/api/messages",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(form)
      }
    )

    if (response.ok) {

      setSent(true)

      setForm({
        name: "",
        email: "",
        subject: "",
        message: ""
      })

    }
  }

  return (
    <section id="contact" className="px-6 py-24">

      <div className="mx-auto max-w-3xl">

        <p className="mb-3 text-sm uppercase tracking-[0.3em] text-gray-500">
          Contact
        </p>

        <h2 className="text-4xl font-bold md:text-5xl">
          Let's work together.
        </h2>

        <p className="mt-6 text-lg leading-8 text-gray-400">
          Have a project or opportunity? Send me a message.
        </p>

        <form
          onSubmit={handleSubmit}
          className="mt-12 space-y-6"
        >

          <div>

            <label className="mb-2 block text-sm text-gray-400">
              Name
            </label>

            <input
              type="text"
              name="name"
              value={form.name}
              onChange={handleChange}
              required
              className="w-full rounded-lg border border-white/10 bg-white/[0.03] px-4 py-3 outline-none focus:border-white/30"
              placeholder="Your name"
            />

          </div>

          <div>

            <label className="mb-2 block text-sm text-gray-400">
              Email
            </label>

            <input
              type="email"
              name="email"
              value={form.email}
              onChange={handleChange}
              required
              className="w-full rounded-lg border border-white/10 bg-white/[0.03] px-4 py-3 outline-none focus:border-white/30"
              placeholder="you@example.com"
            />

          </div>

          <div>

            <label className="mb-2 block text-sm text-gray-400">
              Subject
            </label>

            <input
              type="text"
              name="subject"
              value={form.subject}
              onChange={handleChange}
              required
              className="w-full rounded-lg border border-white/10 bg-white/[0.03] px-4 py-3 outline-none focus:border-white/30"
              placeholder="Subject"
            />

          </div>

          <div>

            <label className="mb-2 block text-sm text-gray-400">
              Message
            </label>

            <textarea
              name="message"
              value={form.message}
              onChange={handleChange}
              required
              rows={6}
              className="w-full resize-none rounded-lg border border-white/10 bg-white/[0.03] px-4 py-3 outline-none focus:border-white/30"
              placeholder="Write your message..."
            />

          </div>

          <button
            type="submit"
            className="rounded-lg bg-white px-6 py-3 font-medium text-black hover:bg-gray-200"
          >
            Send Message
          </button>

          {sent && (
            <p className="text-sm text-green-400">
              Message sent successfully!
            </p>
          )}

        </form>

      </div>

    </section>
  )
}

export default Contact